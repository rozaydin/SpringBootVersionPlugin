# SpringBootVersionPlugin
Plugin searches for application.properties file under
**/src/main/resources** directory if present loads appVersion and appTitle
 properties to project.extensions scope which later can be used within the
 gradle build script. 
 
 This plugin primarily targeted to create a way to set up jar manifest properties
 so version data can be propagated to manifest file. See below for an example 
 configuration
 
 ```
 
 apply plugin: "com.rhtech.springbootversion"
  
  versionProperties {
      appTitle = "application.title"
      appVersion = "application.version"
  }
  
  ...
  
  jar {
      manifest {
          attributes(
                  'Main-Class': 'com.rhtech.application',
                  'Implementation-Title': **project.extensions.title**,
                  'Implementation-Version': **project.extensions.version**,
                  'Internal-Version': **project.extensions.version**,
                  'Implementation-Vendor-Id': 'com.rhtech'
          )
      }
  }
  
 
 ``` 
 
 appTitle and appVersion variables map provided property names from the application.properties file
 these two parameters are later mapped to 
 
 - project.extension.title
 - project.extension.version
 
 above properties can be in gradle build script.
 That is all :)
 
