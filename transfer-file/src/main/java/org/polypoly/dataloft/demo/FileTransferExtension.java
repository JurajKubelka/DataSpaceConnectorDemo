package org.polypoly.dataloft.demo;

import org.eclipse.dataspaceconnector.spi.contract.offer.store.ContractDefinitionStore;
import org.eclipse.dataspaceconnector.spi.system.Inject;
import org.eclipse.dataspaceconnector.spi.system.ServiceExtension;

public class FileTransferExtension implements ServiceExtension {

    public static final String USE_POLICY = "use-eu";
    private static final String EDC_ASSET_PATH = "edc.samples.04.asset.path";
    @Inject
    private ContractDefinitionStore contractStore;
}
