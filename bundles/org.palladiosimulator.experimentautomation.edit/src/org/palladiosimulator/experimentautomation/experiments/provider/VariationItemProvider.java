/**
 */
package org.palladiosimulator.experimentautomation.experiments.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsFactory;
import org.palladiosimulator.experimentautomation.experiments.ExperimentsPackage;
import org.palladiosimulator.experimentautomation.experiments.Variation;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.experimentautomation.experiments.Variation} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class VariationItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Palladiosimulator.org 2008-2017";

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public VariationItemProvider(final AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(final Object object) {
        if (this.itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            this.addTypePropertyDescriptor(object);
            this.addMinValuePropertyDescriptor(object);
            this.addMaxValuePropertyDescriptor(object);
            this.addMaxVariationsPropertyDescriptor(object);
            this.addVariedObjectIdPropertyDescriptor(object);
            this.addNamePropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Type feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addTypePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors
                .add(this.createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
                        this.getResourceLocator(),
                        this.getString("_UI_Variation_type_feature"),
                        this.getString("_UI_PropertyDescriptor_description", "_UI_Variation_type_feature",
                                "_UI_Variation_type"),
                        ExperimentsPackage.Literals.VARIATION__TYPE,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Min Value feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addMinValuePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors
                .add(this.createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
                        this.getResourceLocator(),
                        this.getString("_UI_Variation_minValue_feature"),
                        this.getString("_UI_PropertyDescriptor_description", "_UI_Variation_minValue_feature",
                                "_UI_Variation_type"),
                        ExperimentsPackage.Literals.VARIATION__MIN_VALUE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.REAL_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Max Value feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addMaxValuePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors
                .add(this.createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
                        this.getResourceLocator(),
                        this.getString("_UI_Variation_maxValue_feature"),
                        this.getString("_UI_PropertyDescriptor_description", "_UI_Variation_maxValue_feature",
                                "_UI_Variation_type"),
                        ExperimentsPackage.Literals.VARIATION__MAX_VALUE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.REAL_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Max Variations feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addMaxVariationsPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors
                .add(this.createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
                        this.getResourceLocator(),
                        this.getString("_UI_Variation_maxVariations_feature"),
                        this.getString("_UI_PropertyDescriptor_description", "_UI_Variation_maxVariations_feature",
                                "_UI_Variation_type"),
                        ExperimentsPackage.Literals.VARIATION__MAX_VARIATIONS,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Varied Object Id feature. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addVariedObjectIdPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors
                .add(this.createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
                        this.getResourceLocator(),
                        this.getString("_UI_Variation_variedObjectId_feature"),
                        this.getString("_UI_PropertyDescriptor_description", "_UI_Variation_variedObjectId_feature",
                                "_UI_Variation_type"),
                        ExperimentsPackage.Literals.VARIATION__VARIED_OBJECT_ID,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This adds a property descriptor for the Name feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addNamePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors
                .add(this.createItemPropertyDescriptor(
                        ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
                        this.getResourceLocator(),
                        this.getString("_UI_Variation_name_feature"),
                        this.getString("_UI_PropertyDescriptor_description", "_UI_Variation_name_feature",
                                "_UI_Variation_type"),
                        ExperimentsPackage.Literals.VARIATION__NAME,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate
     * feature for an {@link org.eclipse.emf.edit.command.AddCommand},
     * {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(final Object object) {
        if (this.childrenFeatures == null) {
            super.getChildrenFeatures(object);
            this.childrenFeatures.add(ExperimentsPackage.Literals.VARIATION__VALUE_PROVIDER);
        }
        return this.childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(final Object object, final Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns Variation.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/Variation"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((Variation) object).getName();
        return label == null || label.length() == 0 ? this.getString("_UI_Variation_type")
                : this.getString("_UI_Variation_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to
     * {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void notifyChanged(final Notification notification) {
        this.updateChildren(notification);

        switch (notification.getFeatureID(Variation.class)) {
        case ExperimentsPackage.VARIATION__MIN_VALUE:
        case ExperimentsPackage.VARIATION__MAX_VALUE:
        case ExperimentsPackage.VARIATION__MAX_VARIATIONS:
        case ExperimentsPackage.VARIATION__VARIED_OBJECT_ID:
        case ExperimentsPackage.VARIATION__NAME:
            this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case ExperimentsPackage.VARIATION__VALUE_PROVIDER:
            this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
            return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that
     * can be created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(final Collection<Object> newChildDescriptors, final Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add(this.createChildParameter(ExperimentsPackage.Literals.VARIATION__VALUE_PROVIDER,
                ExperimentsFactory.eINSTANCE.createPolynomialValueProvider()));

        newChildDescriptors.add(this.createChildParameter(ExperimentsPackage.Literals.VARIATION__VALUE_PROVIDER,
                ExperimentsFactory.eINSTANCE.createExponentialValueProvider()));

        newChildDescriptors.add(this.createChildParameter(ExperimentsPackage.Literals.VARIATION__VALUE_PROVIDER,
                ExperimentsFactory.eINSTANCE.createSetValueProvider()));

        newChildDescriptors.add(this.createChildParameter(ExperimentsPackage.Literals.VARIATION__VALUE_PROVIDER,
                ExperimentsFactory.eINSTANCE.createLinearValueProvider()));

        newChildDescriptors.add(this.createChildParameter(ExperimentsPackage.Literals.VARIATION__VALUE_PROVIDER,
                ExperimentsFactory.eINSTANCE.createNestedIntervalsDoubleValueProvider()));

        newChildDescriptors.add(this.createChildParameter(ExperimentsPackage.Literals.VARIATION__VALUE_PROVIDER,
                ExperimentsFactory.eINSTANCE.createNestedIntervalsLongValueProvider()));
    }

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return ((IChildCreationExtender) this.adapterFactory).getResourceLocator();
    }

}
