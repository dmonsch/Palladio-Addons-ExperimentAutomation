/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.variation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.experimentautomation.variation.StructuralVariation;
import de.uka.ipd.sdq.experimentautomation.variation.ValueVariation;
import de.uka.ipd.sdq.experimentautomation.variation.VariationFactory;
import de.uka.ipd.sdq.experimentautomation.variation.VariationPackage;
import de.uka.ipd.sdq.experimentautomation.variation.VariationRepository;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class VariationFactoryImpl extends EFactoryImpl implements VariationFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static VariationFactory init() {
        try {
            final VariationFactory theVariationFactory = (VariationFactory) EPackage.Registry.INSTANCE
                    .getEFactory(VariationPackage.eNS_URI);
            if (theVariationFactory != null) {
                return theVariationFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new VariationFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public VariationFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case VariationPackage.VALUE_VARIATION:
            return this.createValueVariation();
        case VariationPackage.STRUCTURAL_VARIATION:
            return this.createStructuralVariation();
        case VariationPackage.VARIATION_REPOSITORY:
            return this.createVariationRepository();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ValueVariation createValueVariation() {
        final ValueVariationImpl valueVariation = new ValueVariationImpl();
        return valueVariation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public StructuralVariation createStructuralVariation() {
        final StructuralVariationImpl structuralVariation = new StructuralVariationImpl();
        return structuralVariation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public VariationRepository createVariationRepository() {
        final VariationRepositoryImpl variationRepository = new VariationRepositoryImpl();
        return variationRepository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public VariationPackage getVariationPackage() {
        return (VariationPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static VariationPackage getPackage() {
        return VariationPackage.eINSTANCE;
    }

} // VariationFactoryImpl
