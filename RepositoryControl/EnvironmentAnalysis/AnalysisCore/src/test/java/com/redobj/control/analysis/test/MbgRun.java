package com.redobj.control.analysis.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MbgRun {
    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        File f = new File("/Users/mr.zou/idea-workspace/Repository/RepositoryControl/EnvironmentAnalysis/AnalysisCore/mbg.xml");
        ConfigurationParser parser = new ConfigurationParser(warnings);
        Configuration configuration = parser.parseConfiguration(f);
        DefaultShellCallback shellCallback = new DefaultShellCallback(true);
        MyBatisGenerator generator = new MyBatisGenerator(configuration,shellCallback,warnings);
        generator.generate(null);
    }
}
