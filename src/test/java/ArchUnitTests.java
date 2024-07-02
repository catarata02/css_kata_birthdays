import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.syntax.elements.ClassesShouldConjunction;
import com.tngtech.archunit.library.dependencies.SliceRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

class ArchUnitTests {

    private final String basePackage = "ch.kata.architecture"; // Your base package
    private final String applicationLayerPackage = basePackage + ".application..";
    private final String adapterLayerPackage = basePackage + ".adapter..";


    @Test
    void no_cyclic_dependencies() {
        SliceRule rule = slices()
                .matching("ch.kata.architecture.(*)..") // Replace with your package pattern
                .namingSlices("$1")
                .should().beFreeOfCycles();
        rule.check(getAllSrcMainClasses()); 
    }

    @Test
    void application_should_not_depend_on_adapter_layer() {
        ClassesShouldConjunction rule = noClasses().that().resideInAPackage(applicationLayerPackage)
                .should().dependOnClassesThat()
                .resideInAnyPackage(adapterLayerPackage);
        rule.check(getAllSrcMainClasses());
    }

    private JavaClasses getAllSrcMainClasses() {
        return new ClassFileImporter().withImportOption(new ImportOption.DoNotIncludeTests())
                .importPackages(basePackage);
    }
    
}
