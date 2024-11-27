<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite">
    <test name="Test" thread-count="2">
        <classes>
            <class name="org.example.TestRunnerClass">
                <methods>
                    <include name="TC1_Sample_Test_Case_1"/>
                    <include name="TC2_Sample_Test_Case_2"/>
                    <include name="TC3_Sample_Test_Case_3"/>
                    <include name="TC4_Sample_Test_Case_4"/>
                    <include name="TC5_Sample_Test_Case_5"/>
                    <include name="TC6_Sample_Test_Case_6"/>

                </methods>
            </class>
        </classes>
    </test>
</suite>