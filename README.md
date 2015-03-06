# SeleniumTest
My solution is using PageObjects (via the LoadableComponent<T> inheritance) design pattern. This needs a little more code in the beginning, but it's definitely easier to maintain and it separates tests from pages code. Basically we create classes which are modelling application pages, we find elements we interact with and represent it as private class member (cause we care about OOP principles) and expose interaction as public methods. This makes the tests highly readable, it limits changes needed when the app UI is changing.
Test is "testAppRating" in ApplauseTest class.
How to run:
- easiest method for didactic purposes is to import the project (it's a Maven project) in Eclipse and run the test (based on TestNG)
- the "real-world" solution is to have Maven installed and configured on the machine and just run the command "mvn install" from the root of project folder. This will bring all the dependencies and will also compile and run the tests (by using the testsuite.xml configuration file for TestNG.xml). Any test run afterwards can be started by using the command "mv test". Results are displayed in console, there are also reports in <Project Path>\target\surefire-reports\html\index.html, I am using ReportNG, I like their reports more than the standard TEstNG/jUnit reports.

Some notes:
- the browser is configured in config.properties, I only configured Firefox, I did this just to show an easy approach
- I had to use "http://www.google.com/ncr" as start page, in order to aviod getting localized Google search page
- rating in stars is just an aproximation, I preferred to use the exact rating in numbers (aslo printed in console) and round it rather than create an algorithm based on the stars div CSS width
- I had to add a small hack in the tearDown method due to an issue in Selenium/Firefox which sometimes triggers a plugincontainer.exe error

I would gladly discuss any issue you might encountered while running the test (e.g. if your hosts file contains some specific configuration, the project needs some changes, etc.), my projects configuration are usually more complex, for CI and other reasons, this is just a short demo.

