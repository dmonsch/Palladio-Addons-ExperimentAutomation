/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.eventsim.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class EventSimFactoryImpl extends EFactoryImpl implements EventSimFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static EventSimFactory init() {
        try {
            EventSimFactory theEventSimFactory = (EventSimFactory) EPackage.Registry.INSTANCE
                    .getEFactory("http://sdq.ipd.uka.de/ExperimentAutomation/Experiments/EventSim/1.0");
            if (theEventSimFactory != null) {
                return theEventSimFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new EventSimFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EventSimFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case EventSimPackage.EVENT_SIM_CONFIGURATION:
            return createEventSimConfiguration();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EventSimConfiguration createEventSimConfiguration() {
        EventSimConfigurationImpl eventSimConfiguration = new EventSimConfigurationImpl();
        return eventSimConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EventSimPackage getEventSimPackage() {
        return (EventSimPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static EventSimPackage getPackage() {
        return EventSimPackage.eINSTANCE;
    }

} // EventSimFactoryImpl
