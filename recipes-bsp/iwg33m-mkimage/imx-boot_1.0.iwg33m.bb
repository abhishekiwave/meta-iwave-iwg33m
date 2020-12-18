# Copyright 2020 iWave Systems Technologies

require recipes-bsp/imx-mkimage/imx-boot_1.0.bb

DEPENDS_remove = "imx-atf"
DEPENDS += " iwg33m-atf"

do_compile[depends]_remove = "imx-atf:do_deploy"
do_compile[depends] += "iwg33m-atf:do_deploy"

DTBS ?= "${@d.getVar('UBOOT_DTB_NAME').partition('-')[2]}"

do_compile() {
    compile_${SOC_FAMILY}
    # Copy TEE binary to SoC target folder to mkimage
    if ${DEPLOY_OPTEE}; then
        cp ${DEPLOY_DIR_IMAGE}/tee.bin                       ${BOOT_STAGING}
    fi
    # mkimage for i.MX8
    for target in ${IMXBOOT_TARGETS}; do
        if [ "$target" = "flash_linux_m4_no_v2x" ]; then
           # Special target build for i.MX 8DXL with V2X off
           bbnote "building ${SOC_TARGET} - ${REV_OPTION} V2X=NO ${target}"
           make SOC=${SOC_TARGET} ${REV_OPTION} V2X=NO  flash_linux_m4
        else
           bbnote "building ${SOC_TARGET} - ${REV_OPTION} ${target}"
           make SOC=${SOC_TARGET} ${REV_OPTION} ${target}
        fi
        if [ -e "${BOOT_STAGING}/flash.bin" ]; then
            cp ${BOOT_STAGING}/flash.bin ${S}/${BOOT_CONFIG_MACHINE}-${target}
        fi
    done
}