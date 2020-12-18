FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

INI_UNCOMMENT_ASSIGNMENTS_remove_iwg33m = " \ 
    \\[shell\\] \
    size=1920x1080 \
"

INI_UNCOMMENT_ASSIGNMENTS_append_iwg33m = " \
    \\[output\\] \
    name=DSI-1 \
    transform=180 \
"
