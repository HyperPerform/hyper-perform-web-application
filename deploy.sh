#!/bin/bash
set -e # Exit with nonzero exit code if anything fails

SOURCE_BRANCH="develop"

# Pull requests and commits to other branches shouldn't try to deploy, just build to verify
if [ "$TRAVIS_PULL_REQUEST" != "false" -o "$TRAVIS_BRANCH" != "$SOURCE_BRANCH" ]; then
    echo "Skipping deploy; just doing a build."
    exit 0
fi

echo -e "Publishing javadoc...\n"

cp -R build/docs/javadoc $HOME/javadoc-latest

cd $HOME
git config --global user.email "hyperpeformteam@gmail.com"
git config --global user.name "Travis"
git clone --quiet --branch=gh-pages https://${GH_TOKEN}@github.com/claudioMDS/hyper-perform gh-pages > /dev/null

cd gh-pages
git rm -rf ./javadoc
cp -Rf $HOME/javadoc-latest ./javadoc
git add -f .
git commit -m "Latest javadoc on successful travis build $TRAVIS_BUILD_NUMBER auto-pushed to gh-pages"
git push -fq origin gh-pages > /dev/null

echo -e "Published Javadoc to gh-pages.\n"