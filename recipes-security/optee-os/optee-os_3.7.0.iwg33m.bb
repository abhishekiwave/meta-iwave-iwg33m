# Copyright (C) 2020 iWave Systems Technologies

require recipes-security/optee-imx/optee-os_3.7.0.imx.bb

SRC_URI = "git://git-codecommit.ap-south-1.amazonaws.com/v1/repos/imx-optee-os-iWave.git;protocol=ssh;branch=5.4.24_2.1.0-iwg33m-R3.0-REL0.1"
SRCREV = "ffbeaf22964018a242ebd00b61a188f61d2f38dc"

PLATFORM_FLAVOR = "${@d.getVar('MACHINE')[1:].replace('-','_')}"
