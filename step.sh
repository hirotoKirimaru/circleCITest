#!/bin/sh
BASE_COMMIT= git show-branch --sha1-name master | tail -1 | awk '{print substr($0, index($0, "[") +1, index($0, "]") -2)}'
#デバッグ文
echo $BASE_COMMIT
echo ./node_modules/.bin/cloc --diff --vcs=git $BASE_COMMIT HEAD
# 差分
./node_modules/.bin/cloc --diff --vcs=git $BASE_COMMIT HEAD