#!/bin/bash
git add .
git commit -a -m "$(date)"
git push 
ssh://5156b10de0b8cd7b4200011e@RUSocial-RUSocialBackend.rhcloud.com/~/git/RUSocial.git/
rhc tail RUSocial
