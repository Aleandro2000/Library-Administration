build:
	echo "Main-Class: libraryAdministration" > MANFIEST.MF
	javac libraryAdministration.java
	jar cvmf MANFIEST.MF libraryAdministration.jar libraryAdministration.class
run:
	bash libraryAdministration.sh