require ${COREBASE}/meta/recipes-graphics/mesa/mesa.inc

DEPENDS += "python-mako-native"

inherit pythonnative update-alternatives

SRC_URI = "git://anongit.freedesktop.org/mesa/mesa;branch=13.0 \
           file://mesa_version_diff.patch \
           file://0001-Simplify-wayland-scanner-lookup.patch"

SRCREV = "c8ece92ded9337b9ed60aa9568b41313025a1406"

LIC_FILES_CHKSUM = "file://docs/license.html;md5=899fbe7e42d494c7c8c159c7001693d5"

ALTERNATIVE_mesa-megadriver = "i965_dri"
ALTERNATIVE_LINK_NAME[i965_dri] = "/usr/lib/dri/i965_dri.so"
ALTERNATIVE_TARGET_mesa-megadriver[i965_dri] = "/usr/lib/dri/i965_dri.so"

S = "${WORKDIR}/git"

EXTRA_OECONF = "--build=$host --enable-glx-tls"

PACKAGECONFIG = "egl gles dri dri3 \
		 ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)}\
		 ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)}\
		"

PACKAGECONFIG[debug] = "--enable-debug"
PACKAGECONFIG[wayland] = ",,wayland-native wayland"

#because we cannot rely on the fact that all apps will use pkgconfig,
#make eglplatform.h independent of MESA_EGL_NO_X11_HEADER
do_install_append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'egl', 'true', 'false', d)}; then
        sed -i -e 's/^#if defined(MESA_EGL_NO_X11_HEADERS)$/#if defined(MESA_EGL_NO_X11_HEADERS) || ${@bb.utils.contains('PACKAGECONFIG', 'x11', '0', '1', d)}/' ${D}${includedir}/EGL/eglplatform.h
    fi
}

RPROVIDES_mesa-megadriver = "mesa-driver-i965"
RCONFLICTS_mesa-megadriver = "mesa-driver-i965"
RREPLACES_mesa-megadriver = "mesa-driver-i965"