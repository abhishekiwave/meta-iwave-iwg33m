# Copyright (C) 2020 iWave Systems Technologies

require recipes-bsp/imx-atf/imx-atf_2.2.bb

SRC_URI = "git://git-codecommit.ap-south-1.amazonaws.com/v1/repos/imx-atf-iWave.git;protocol=ssh;branch=main"
SRCREV = "3c8362e0c70317bf37eaf4da05a14a61948a8c97"

EXTRA_OEMAKE += " \
    MACHINE=${@d.getVar('MACHINE').replace('-','_')} \
"