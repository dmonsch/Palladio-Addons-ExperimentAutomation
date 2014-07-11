package de.uka.ipd.sdq.experimentautomation.application;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

/**
 * Only used to document a single experiment run. For instance, a logger to use an object of this
 * class to output some information about an experiment.
 * 
 * @author Merkle, Sebastian Lehrig
 */
public class ExperimentMetadata {

    private static final String LINE_FEED = "\r\n";

    private String experimentName;
    private String virtualMachineArguments;
    private Date startTime;
    private Date endTime;

    public ExperimentMetadata() {
        // nothing to do
    }

    public String getExperimentName() {
        return this.experimentName;
    }

    public void setExperimentName(final String experimentName) {
        this.experimentName = experimentName;
    }

    public String getVirtualMachineArguments() {
        return this.virtualMachineArguments;
    }

    public void setVirtualMachineArguments(final String virtualMachineArguments) {
        this.virtualMachineArguments = virtualMachineArguments;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(final Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(final Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Experiment name:        " + this.experimentName + "\r\n");
        builder.append("Workstation name:       " + this.getWorkstationName() + "\r\n");
        builder.append("VM arguments:           " + this.getVMArguments() + "\r\n");
        builder.append("Started:                " + this.startTime + "\r\n");
        builder.append("Finished:               " + this.endTime + "\r\n");

        // append OS properties
        builder.append(this.getOSProperties());

        // append VM properties
        builder.append(this.getVMProperties());

        return builder.toString();
    }

    private String getWorkstationName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (final UnknownHostException e) {
            return "Could not determine the host name";
        }
    }

    private String getVMArguments() {
        final RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        final List<String> arguments = bean.getInputArguments();
        return arguments.toString();
    }

    private String getVMProperties() {
        final RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        final StringBuilder b = new StringBuilder();
        b.append(LINE_FEED);
        b.append("--[ Virtual Machine ]---------------------------------------." + LINE_FEED);
        b.append("Name:                   " + bean.getName() + LINE_FEED);
        b.append("Specification Name:     " + bean.getSpecName() + LINE_FEED);
        b.append("Specification Vendor:   " + bean.getSpecVendor() + LINE_FEED);
        b.append("Specification Version:  " + bean.getSpecVersion() + LINE_FEED);
        b.append("VM Name:                " + bean.getVmName() + LINE_FEED);
        b.append("VM Vendor:              " + bean.getVmVendor() + LINE_FEED);
        b.append("VM Version:             " + bean.getVmVersion() + LINE_FEED);
        return b.toString();
    }

    private String getOSProperties() {
        final OperatingSystemMXBean bean = ManagementFactory.getOperatingSystemMXBean();
        final StringBuilder b = new StringBuilder();
        b.append(LINE_FEED);
        b.append("--[ Operating System ]---------------------------------------" + LINE_FEED);
        b.append("Architecture:           " + bean.getArch() + LINE_FEED);
        b.append("Available Processors:   " + bean.getAvailableProcessors() + LINE_FEED);
        b.append("Version:                " + bean.getVersion() + LINE_FEED);
        return b.toString();
    }

}
