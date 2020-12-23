# Copyright (C) 2020 iWave Systems Technologies

require recipes-kernel/linux/linux-imx_5.4.bb

SRC_URI = "git://git-codecommit.ap-south-1.amazonaws.com/v1/repos/linux-imx-iWave.git;protocol=ssh;branch=5.4.24_2.1.0-iwg33m-R3.0-REL0.1"
SRCREV = "f79cfd4f8446501ccd4ba602eb3863caa4474cc2"

do_copy_defconfig () {
    install -d ${B}
    mkdir -p ${B}
    # copy latest imx8mq_iwg33m_defconfig to use for iwg33m
    cp ${S}/arch/arm64/configs/iwg33m_defconfig ${B}/.config
    cp ${S}/arch/arm64/configs/iwg33m_defconfig ${B}/../defconfig
}

do_compile_append () {
	for dtbf in ${KERNEL_DEVICETREE}; do
		dtb=`normalize_dtb "$dtbf"`
		oe_runmake DTC_FLAGS="-@" $dtb
	done
}
