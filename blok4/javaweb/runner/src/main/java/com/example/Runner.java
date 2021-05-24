package com.example;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class Runner {

    // http://localhost:8082/
    // Hot deploy of classes DOES NOT WORK! You need to restart the runner for testing your changes.

    public static void main(String[] args) throws LifecycleException, ServletException {
        String projectRoot = "blok4/javaweb/simplewebapp/";
        String webappLocation = projectRoot + "src/main/webapp/";
        String classesLocation = projectRoot + "target/classes";

        System.out.println("Configuring app with basedir: " + new File(projectRoot).getAbsolutePath());

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8082);

        // Add some roles and users for testing security:
        // tomcat.addRole("bram", "user");
        // tomcat.addRole("bram", "admin");
        // tomcat.addUser("bram", "bram");

        // This is equivalent to adding a web application to Tomcat's webapps directory:
        StandardContext ctx = (StandardContext) tomcat.addWebapp("", new File(webappLocation).getAbsolutePath());

        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources,
                "/WEB-INF/classes",
                new File(classesLocation).getAbsolutePath(),
                "/"));
        ctx.setResources(resources);

        tomcat.start();
        System.out.println("Webapp started at: http://localhost:8082/");
        tomcat.getServer().await();
    }
}
