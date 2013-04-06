#!/bin/bash
git add . | tee -a ../RUSocial_server.log
git commit -a -m "$(date)" | tee -a ../RUSocial_server.log
git push ssh://5156b10de0b8cd7b4200011e@RUSocial-RUSocialBackend.rhcloud.com/~/git/RUSocial.git/ | tee -a ../RUSocial_server.log
rhc tail RUSocial | tee -a ../RUSocial_server.log 