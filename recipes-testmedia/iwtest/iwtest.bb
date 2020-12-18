DESCRIPTION = "Test Media File for iWave Release BSP"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

S = "${WORKDIR}"

FILES_${PN} = "iwtest"

SRC_URI = "file://AudioTest.wav \
	   file://KungFuHustle.mov"

PROVIDES = "iwtest"

do_install() {
    install -d ${D}/iwtest
    install -m 0644 ${WORKDIR}/AudioTest.wav ${D}/iwtest
    install -m 0644 ${WORKDIR}/KungFuHustle.mov ${D}/iwtest
}

# These libraries shouldn't get installed in world builds unless something
# explicitly depends upon them.
EXCLUDE_FROM_WORLD = "1"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1" 
INHIBIT_PACKAGE_STRIP = "1" 
