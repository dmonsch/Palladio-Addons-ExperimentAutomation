/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.experimentautomation.experiments.provider;


import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;

import de.uka.ipd.sdq.experimentautomation.variation.provider.ExperimentAutomationEditPlugin;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PCMModelFilesItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMModelFilesItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addAllocationFilePropertyDescriptor(object);
			addUsagemodelFilePropertyDescriptor(object);
			addSystemFilePropertyDescriptor(object);
			addRepositoryFilePropertyDescriptor(object);
			addResourceenvironmentFilePropertyDescriptor(object);
			addMiddlewareRepositoryFilePropertyDescriptor(object);
			addEventMiddlewareRepositoryFilePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Allocation File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllocationFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PCMModelFiles_allocationFile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PCMModelFiles_allocationFile_feature", "_UI_PCMModelFiles_type"),
				 ExperimentsPackage.Literals.PCM_MODEL_FILES__ALLOCATION_FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Usagemodel File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsagemodelFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PCMModelFiles_usagemodelFile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PCMModelFiles_usagemodelFile_feature", "_UI_PCMModelFiles_type"),
				 ExperimentsPackage.Literals.PCM_MODEL_FILES__USAGEMODEL_FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the System File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSystemFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PCMModelFiles_systemFile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PCMModelFiles_systemFile_feature", "_UI_PCMModelFiles_type"),
				 ExperimentsPackage.Literals.PCM_MODEL_FILES__SYSTEM_FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Repository File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRepositoryFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PCMModelFiles_repositoryFile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PCMModelFiles_repositoryFile_feature", "_UI_PCMModelFiles_type"),
				 ExperimentsPackage.Literals.PCM_MODEL_FILES__REPOSITORY_FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Resourceenvironment File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResourceenvironmentFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PCMModelFiles_resourceenvironmentFile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PCMModelFiles_resourceenvironmentFile_feature", "_UI_PCMModelFiles_type"),
				 ExperimentsPackage.Literals.PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Middleware Repository File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMiddlewareRepositoryFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PCMModelFiles_middlewareRepositoryFile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PCMModelFiles_middlewareRepositoryFile_feature", "_UI_PCMModelFiles_type"),
				 ExperimentsPackage.Literals.PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Event Middleware Repository File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEventMiddlewareRepositoryFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PCMModelFiles_eventMiddlewareRepositoryFile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PCMModelFiles_eventMiddlewareRepositoryFile_feature", "_UI_PCMModelFiles_type"),
				 ExperimentsPackage.Literals.PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns PCMModelFiles.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PCMModelFiles"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((PCMModelFiles)object).getAllocationFile();
		return label == null || label.length() == 0 ?
			getString("_UI_PCMModelFiles_type") :
			getString("_UI_PCMModelFiles_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(PCMModelFiles.class)) {
			case ExperimentsPackage.PCM_MODEL_FILES__ALLOCATION_FILE:
			case ExperimentsPackage.PCM_MODEL_FILES__USAGEMODEL_FILE:
			case ExperimentsPackage.PCM_MODEL_FILES__SYSTEM_FILE:
			case ExperimentsPackage.PCM_MODEL_FILES__REPOSITORY_FILE:
			case ExperimentsPackage.PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE:
			case ExperimentsPackage.PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE:
			case ExperimentsPackage.PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ExperimentAutomationEditPlugin.INSTANCE;
	}

}
