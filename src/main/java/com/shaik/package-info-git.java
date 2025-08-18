package com.shaik;

/**
 * 1. create a project folder in IDE
 * 2. select the folder and use command : git init (if there is not git hidden folder to know hidden folders use commnd : ls -a)
 * 3. create a repo in GitHub
 * 4. use command : git remote add origin repo Url (https://github.com/shaik-shafin/First-Project-Quiz.git)
 * 5. to check version of repo use command : git remote -v\
 * 6. to check the current branch use command : git branch
 * 7. to change the branch name use command : git branch -M "costume-name"
 * 8. to commit to master branch use command : git push -u origin main (main means the branch name it would be anything name)
 * 9. use -u to make next commit simple like next time you just need to use the command for push like : git push
 * 10. instead of using git push origin main
 * 11. to check the status of the git use : git status
 * 12. for clone the project use : git clone
 * 13. to add all file to git use : git add
 * 14. to commit files use : git commit -m "commit message" (commit to local repo)
 *
 * process for new project :-
 * ------------------------
 * 1. create a project folder
 * 2. use whether it has hidden git folder or not
 * 3. use command : ls -a
 * 4. add files into the project
 * 5. check the git status use command : git status
 * 6. if you notice untracked files and you need to commit them then before commit you need to add them
 * 7. use command : git add .
 * 8. now you have commit them
 * 9. use command : git commit -m "git message"
 * 10. it will committed to your local system repo
 * 11. so in order to upload this in GitHub
 * 12. create new repo in GitHub
 * 13. before commit the files to remote repo
 * 14. you have to run a command : git remote add origin <-- git repo url --> (ex: https://github.com/shaik-shafin/First-Project-Quiz.git)
 * 15. note that origin is nothing but remote repo name by default you can use any name but its good practice to let it be origin and
 * 16. and add the git remote repo url to connect
 * 17. how did we know that is remote is added or not
 * 18. use command : git remote -v
 * 19. to check in which branch are we in
 * 20. use command : git branch
 * 21. you will get default branch name that is master it will be default
 * 22. if you want create you can create another branch also
 * 23. to add new branch use command : git checkout -b <branch-name>
 * 24. later on commit to remote you have to use this branch like git push -u origin <branch-name>
 * 25. if you have multiple branches in remote repo you want to switch from one branch to another branch then you can use the command
 * 26. command : git checkout <branch-name>
 * 27. if you want to delete the branch you can use the command
 * 28. command : git branch -d <branch-name> and if you want to delete the branch from remote repo use command : git push origin --delete <branch-name>
 * 29. if you have two branch and you want to merge branch1 with main you have to use the command
 * 30. git merge main
 * 31. to pull remote code to local you can use the command : git pull origin main
 * 32. you compare difference between two branch use command : git diff main
 * 33. you added a file to commit by mistake so you can use command : git reset <file-name>
 * 34. you have committed to your local branch by mistake you can use command : git reset HEAD1 (which means take a step back from current commit)
 * 35. if you want to see the git commit history use command : git log
 * 36. if you want to go multiple step back to reset an commit you can use the command : git reset <hash-value> (hash - is a unique value which generate for every new commit)
 * 37. if you don't want only to reset the git you also want to reset local
 * 38. use command : git reset --hard <hash-value>
 * 39. fork - you can copy other project and create a new repo in you account and further you can make the change to that repo and you can create the pull request but most they don't allow
 * **/