#!/bin/env bash

# 差分比較元のコミットハッシュ
readonly BASE_COMMIT= git show-branch --sha1-name master | tail -1 | awk '{print substr($2, index($2, "[") +1, index($2, "]") -2)}'
# 収集対象言語
readonly LANGS='["Java","JavaScript"]'

# リポジトリから一時フォルダへclone
git clone $CIRCLE_REPOSITORY_URL ./_work
cd _work

# clocでステップ数を取得
step_total=`cloc --vcs=git --json --exclude-list-file=../stepignore.txt`
step_diff=`cloc --json --exclude-list-file=../stepignore.txt --diff $BASE_COMMIT HEAD`

# 一時フォルダの削除
cd ..
rm -rf ./_work

# 全体のステップ数（ロジック、コメント）
logic_total=`echo $step_total | jq '[ .'$LANGS'.code ] | add'`
comment_total=`echo $step_total | jq '[ .'$LANGS'.comment,.'$LANGS'.blank ] | add'`

# 追加・修正分のステップ数（ロジック、コメント）
logic_added=`echo $step_diff | jq '.added | [ .'$LANGS'.code ] | add'`
logic_modified=`echo $step_diff | jq '.modified | [ .'$LANGS'.code ] | add'`
comment_added=`echo $step_diff | jq '.added | [ .'$LANGS'.comment,.'$LANGS'.blank ] | add'`
comment_modified=`echo $step_diff | jq '.modified | [ .'$LANGS'.comment,.'$LANGS'.blank ] | add'`

# 流用分を算出
logic_same=$((logic_total-logic_added-logic_modified))
comment_same=$((comment_total-comment_added-comment_modified))

# 出力
{
  echo "■ロジックのみ"
  echo "・追加："$logic_added
  echo "・修正："$logic_modified
  echo "・流用："$logic_same
  echo "---"
  echo "・計　："$logic_total
  echo ""
  echo "■コメント・空行を含む"
  echo "・追加："$((logic_added+comment_added))
  echo "・修正："$((logic_modified+comment_modified))
  echo "・流用："$((logic_same+comment_same))
  echo "---"
  echo "・計　："$((logic_total+comment_total))
}>./step-result.txt