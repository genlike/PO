mmt/app/App.class:
	javac -cp po-uilib.jar:. `find mmt -name *.java`

run:
	java -cp po-uilib.jar:. -Dimport=test.import  mmt.app.App

clean:
	find mmt -name *.class -delete
jar:
	jar cvf entregaIntermedia.jar mmt