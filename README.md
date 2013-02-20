RUSocial
========
*Copied from email*

What to do everyday before you work
  git pull upstream develop
	
	This is a MUST! If this is not done, and your code goes too far along the stream, it will get out of sync and you will need to manually copy and paste code 	around until it's back into sync!

How to commit/upload your code
	git status <-- gives you the files that have changed
	git diff (filename) <--- gives you the changes in each file based on which you enter as your filename
	git commit -a <-- commits your changes, you will be prompted to enter a log message, please refer to * for formatting
	git push (remote name) (local branch name) :  (remote branch name) <-- this is after the commit to upload it to your remote repo
		If you did all the steps correctly according to https://help.github.com/articles/create-a-repo , and you type in the "git remote -v" command, you should 		have "origin" as your own remote repo and "upstream" as the base repo.
		If that's the case, the command should be something like "git push origin develop"
		
		If the correct command is entered, it should prompt you for user/pass for github, then to which it should properly upload your changed code into the 		your personal remote repo.

* Commit format (italicized)
Status - refers to how far along in the issue it is. Under no circumstances should the term "Fixed" be used unless the issue is complete.
issueNumber - https://github.com/k22mak/RUSocial/issues?milestone=&page=1&state=open <-- the task number you are currently working on.

A detailed description of what was changed and what was done

Status #issueNumber


How you pull back into the group repo
	If the above steps were done correctly, you should be able to see the changes you have done on www.github.com under your personal fork of the repo.
	Once this is complete and you are ready to pull the changed code into the parent repo, there should be a "Pull Request" button on your top bar.

	Pull into the parent repo following the GUI steps. Please follow the same commit format as listed above.

Merging your branches
	This part is a little bit tricky so I'll try to be as detailed as possible.
	Under proper repository tracking, every new task you work on should be done under a new branch.
	
	I have created a dummy branch for this case.



	
	As explained before, all completed tasks should be done under the "develop" branch. Assume I have done a bit of coding and have finished the task for dummy branch. Now I would like to merge the changes I have done in the dummyBranch back into the develop branch.

1. Commit your changes (look above for how to do this)
2. Switch to your develop branch "git checkout develop"


3. Now you can type "git merge dummyBranch" 
	This should now take all your changes from dummyBranch, and merge it back into your develop.

4. Do the same commits as normal (look above)
