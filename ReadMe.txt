Pour pousher la premi�re fois un projet :

git init : cr�e un dossier de version .get
git config --global user.email "chafiayouness@gmail.com"
git config --global user.name "ychafia"
git config --global color.ui true
git status : les fichiers qui �taient modifi�s depuis le dernier push
git commit -m "back end fonctionnel"
git remote add origin https://github.com/ychafia/ListeDeCourses.git : ajout d'un d�p�t distant vers l'url
git remote -v 
git push -u origin master
git status 

Les commits suivant :

git status
git add --all
git status
git commit -m "second commit"
git push -u origin master