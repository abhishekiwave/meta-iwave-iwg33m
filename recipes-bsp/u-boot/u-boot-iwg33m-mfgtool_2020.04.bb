# Copyright (C) 2020 iWave Systems Technologies

require u-boot-iwg33m_${PV}.bb
require recipes-bsp/u-boot/u-boot-mfgtool.inc

SPL_IMAGE = "${SPL_BINARYNAME}-${MACHINE}-mfgtool-${PV}-${PR}"
SPL_SYMLINK = "${SPL_BINARYNAME}-mfgtool-${MACHINE}"

SSTATE_DUPWHITELIST = "/"
