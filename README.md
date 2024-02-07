<!DOCTYPE html>
<html lang="en">

<body>

<h1>Table of Contents</h1>
<ul>
    <li><a href="#bdd-overview">What is BDD?</a></li>
    <li><a href="#gherkin-language">Gherkin Language</a></li>
    <li><a href="#feature-file">What is a Feature File?</a></li>
    <li><a href="#step-definition">What is a Step Definition?</a></li>
    <li><a href="#runner-class">What is a Runner Class?</a></li>
    <li><a href="#hooks">Hooks</a></li>
    <li><a href="#generate-reports">How to Generate Reports?</a></li>
    <li><a href="#take-screenshot">How to Take a Screenshot in BDD?</a></li>
    <li><a href="#dependencies">Dependencies Used for BDD</a></li>
</ul>

<h1 id="bdd-overview">What is BDD?</h1>
<p>In simple words, Behavior-Driven Development (BDD) is an approach to software development that focuses on the behavior of the system from the user's perspective. It encourages collaboration among different team members, including developers, testers, and non-technical stakeholders.

In BDD, the desired behavior of a software feature is described in plain language, often using a format called Gherkin. This description is then used to create automated tests that verify whether the software behaves as expected. The process involves writing scenarios in a structured manner, using keywords like Given, When, and Then to outline the preconditions, actions, and expected outcomes.</p>

<h2>Advantages of BDD:</h2>
<ol>
    <li>
        <h4>Improved Communication:</h4>
        <p>By employing a common language, team members can enhance their understanding and facilitate discussions about the desired behavior of features.</p>
    </li>
    <li>
        <h4>Enhanced Collaboration:</h4>
        <p>BDD encourages active participation from all stakeholders in the development process, fostering collaboration among developers, testers, and business stakeholders.</p>
    </li>
    <li>
        <h4>Living Documentation:</h4>
        <p>BDD scenarios act as living documentation, providing an always up-to-date and easily comprehensible representation of the system's behavior.</p>
    </li>
    <li>
        <h4>Quality Assurance:</h4>
        <p>Automated tests derived from BDD scenarios play a crucial role in ensuring that the software not only meets the specified requirements but continues to do so as it evolves, thus ensuring quality.</p>
    </li>
</ol>
<p>In essence, BDD is a methodology designed to ensure that every participant in the development process comprehends what needs to be built, understands how it should behave, and ensures alignment with the expectations of end-users.</p>
<h2 id="gherkin-language">Gherkin Language: Simplifying Software Communication</h2>

<p>The Gherkin language serves as a specialized communication tool to elucidate how computer programs should behave. It is intentionally crafted to be accessible to both individuals with minimal coding knowledge and tech-savvy experts.</p>

<p>In Gherkin, we articulate the steps that our software should take in a straightforward manner. Utilizing keywords such as "Given" to denote the starting point, "When" to specify the action being taken, and "Then" to express the expected outcome, Gherkin provides a structured and human-readable format.</p>

<h3>Example:</h3>
<pre>
<code>
Feature: Shopping Cart

  Scenario: Adding Items
    Given the user has an empty shopping cart
    When the user adds a book to the cart
    Then the cart should contain one book
</code>
</pre>

<p>In this example, we focus on a shopping cart within an online store. The scenario illustrates that when the cart is empty and the user adds a book, the cart should subsequently contain one book. This straightforward approach clarifies the desired behavior for the computer to execute.</p>

<p>The Gherkin language facilitates collaborative efforts, fostering effective communication among team members, whether they are coding experts or regular users. It provides a clear and universal way to articulate and understand how the software should behave.</p>

<h2 id="feature-file">What is a Feature File in BDD?</h2>
<p>A feature file is a plain-text document written in the Gherkin language. It describes the expected behavior of a specific feature in a software application. Each feature file typically contains scenarios that outline different situations or use cases. These files are an essential part of Behavior-Driven Development (BDD) and are used with tools like Cucumber to create automated tests. Feature files promote collaboration among team members, ensuring a shared understanding of how the software should behave from both technical and non-technical perspectives.</p>
<!-- Additional content -->

<h2 id="step-definition">What is a Step Definition?</h2>
<p>A step definition is the code implementation that corresponds to each step in a Gherkin feature file. It provides the executable instructions for Cucumber to follow when it encounters specific actions or verifications described in a scenario. These step definitions are written in a programming language and are linked to the Gherkin steps using annotations, such as @Given, @When, and @Then. Step definitions bridge the gap between the human-readable scenarios and the actual code that tests the behavior of the software, allowing for collaboration between non-technical and technical team members.</p>
<!-- Additional content -->

<h2 id="runner-class">What is a Runner Class?</h2>
<p>In the context of BDD with Cucumber and JUnit, a "Runner Class" is a class that orchestrates the execution of Cucumber scenarios. It essentially acts as a bridge between the Cucumber features and the step definitions, ensuring that the appropriate steps are executed for each scenario.

<h4>Sample Runner class:</h4>

<pre>
  <code>
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",<br>
    glue = "stepDefinition",<br>
    tags = "@smoke", // You can use tags to specify which scenarios to run<br>
    plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"}
)
public class TestRunner {

}
  </code>
</pre>
</p>
<!-- Additional content -->

<h2 id="hooks">Hooks</h2>
<p>Hooks in the context of Cucumber (BDD) are special methods or functions that allow you to perform setup and teardown activities before and after scenarios. They provide a way to execute code at specific points in the test execution lifecycle.

<pre>
<code>

@Before
	public void setUp() {
			
		System.out.println("Pre Condition");
	}

	@After
	public void tearDown() {
		
		System.out.println("Post Condition");

	}
  
</code>
  
</pre>

</p>
<!-- Additional content -->

<h2 id="generate-reports">How to Generate Reports?</h2>
<p>To generate reports in BDD, we need to include plugins in the Test Runner Class. In the Test Runner Class, within the `@CucumberOptions` annotation, the `plugin` parameter should be added to specify the desired reporting options. To achieve this, you can set the `plugin` parameter to include a 'pretty' console output and define the type of report format, such as HTML, JSON, or XML, that you want to generate. Additionally, specify the file path where the report will be generated.

<h4>For example:</h4>

<pre>
  <code>
    `@CucumberOptions(features = "src/test/resources/features", glue = "com.example.steps", plugin = {"pretty", "html:target/cucumber-reports"})
public class TestRunner {

}
  </code> 
</pre>

In this example, the `plugin` parameter is configured to produce both a 'pretty' console output and an HTML report. The HTML report will be generated in the 'target/cucumber-reports' directory. You can customize the plugins and report formats based on your reporting requirements."</p>

<h2 id="take-screenshot">How to Take a Screenshot in BDD?</h2>
<p>To take a screenshot, we can use the <code>@After</code> annotation of the Cucumber library to provide implementation to take a screenshot through the Selenium library.</p>
<pre>
  <code>
    @After
	public void getScreenShot(Scenario scenario) throws WebDriverException, IOException {
		String name = scenario.getName();

		if (scenario.isFailed()) {
			WebDriverUtility.takeAScreenShot(TestRunnerSmoke.driver,
					"./src/test/resources/screenshots/" + name + ".png");
		}

	}
  </code>
</pre>

<h2 id="dependencies">Dependencies Used for BDD</h2>
<pre>
    <code class="!whitespace-pre hljs language-xml"><span class="hljs-tag">&lt;<span class="hljs-name">dependencies</span>&gt;</span>
    <span class="hljs-comment">&lt;!-- Cucumber for Java --&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>io.cucumber<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>cucumber-java<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">version</span>&gt;</span>7.14.0<span class="hljs-tag">&lt;/<span class="hljs-name">version</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>
    <span class="hljs-comment">&lt;!-- JUnit Jupiter API --&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>org.junit.jupiter<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>junit-jupiter-api<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">version</span>&gt;</span>5.10.0<span class="hljs-tag">&lt;/<span class="hljs-name">version</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">scope</span>&gt;</span>test<span class="hljs-tag">&lt;/<span class="hljs-name">scope</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>
   <span class="hljs-comment">&lt;!-- Cucumber JUnit Runner --&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>io.cucumber<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>cucumber-junit<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">version</span>&gt;</span>7.14.0<span class="hljs-tag">&lt;/<span class="hljs-name">version</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">scope</span>&gt;</span>test<span class="hljs-tag">&lt;/<span class="hljs-name">scope</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>
    <span class="hljs-comment">&lt;!-- Selenium Java --&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">dependency</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">groupId</span>&gt;</span>org.seleniumhq.selenium<span class="hljs-tag">&lt;/<span class="hljs-name">groupId</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">artifactId</span>&gt;</span>selenium-java<span class="hljs-tag">&lt;/<span class="hljs-name">artifactId</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">version</span>&gt;</span>4.13.0<span class="hljs-tag">&lt;/<span class="hljs-name">version</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">dependency</span>&gt;</span>
<span class="hljs-tag">&lt;/<span class="hljs-name">dependencies</span>&gt;</span>
</code></div></div></pre>
<!-- Additional content -->

</body>
</html>
