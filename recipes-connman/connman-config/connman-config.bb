SUMMARY = "Connman config to disable background scanning"
DESCRIPTION = "This is the ConnMan configuration to disable wifi background scanning"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

S = "${WORKDIR}"

FILES_${PN} = "${sysconfdir}/connman/main.conf"

SRC_URI = "file://main.conf"

PROVIDES = "connman-config"

do_install() {
    install -D -p -m0644 ${WORKDIR}/main.conf ${D}${sysconfdir}/connman/main.conf
}

# These libraries shouldn't get installed in world builds unless something
# explicitly depends upon them.
EXCLUDE_FROM_WORLD = "1"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1" 
INHIBIT_PACKAGE_STRIP = "1" 
