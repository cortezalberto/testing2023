package com.example.apirest.archunit;


import com.example.apirest.controllers.BaseController;
import com.example.apirest.services.BaseService;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import jakarta.persistence.Entity;


import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.example.apirest", importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchUnitTest {

    //Probando Github Actions


    @ArchTest
    public static final ArchRule layerRule =
    layeredArchitecture().consideringAllDependencies()
    .layer("Controller").definedBy("com.example.apirest.controllers")
    .layer("Service").definedBy("com.example.apirest.services")
    .layer("Persistence").definedBy("com.example.apirest.repositories")

    .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
    .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
    .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");
    @ArchTest
    public static final ArchRule controllerNameRule =
            classes().that().haveSimpleNameEndingWith("Controller").should().resideInAPackage("com.example.apirest.controllers");
    @ArchTest
    public static final ArchRule controllerBaseRule =
            classes().that().haveSimpleNameEndingWith("Controller").should().implement(BaseController.class)
            .orShould().haveSimpleName("BaseController");

    @ArchTest
    public static final ArchRule serviceNameRule =
            classes().that().haveSimpleNameEndingWith("ServiceImpl").should().resideInAPackage("com.example.apirest.services");

    @ArchTest
    public static final ArchRule serviceBaseRule =
            classes().that().haveSimpleNameEndingWith("ServiceImpl").should().implement(BaseService.class)
                    .orShould().haveSimpleName("BaseServiceImpl");

    @ArchTest
    public static final ArchRule repositoryNameRule =
            classes().that().haveSimpleNameEndingWith("Repository").should().resideInAPackage("com.example.apirest.repositories");

    @ArchTest
    public static final ArchRule entitiesAnnotation =
            classes().that().resideInAPackage("com.example.apirest.entities").should().beAnnotatedWith(Entity.class)
            .orShould().haveSimpleName("Base");
}
