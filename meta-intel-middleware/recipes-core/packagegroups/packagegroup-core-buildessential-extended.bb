DESCRIPTION = "Extended list of packages for build essentials"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

PACKAGES = "packagegroup-core-buildessential-extended"

RDEPENDS_packagegroup-core-buildessential-extended = "\
    alsa-lib \
    alsa-utils \
    autoconf \
    automake \
    bash \
    binutils \
    binutils-symlinks \
    bison \
    bzip2 \
    chkconfig \
    cifs-utils \
    cmake \
    coreutils \
    cpp \
    cpp-symlinks \
    dialog \
    dosfstools \
    file \
    flex \
    fuse-exfat \
    exfat-utils \
    g++ \
    g++-symlinks \
    gawk \
    gcc \
    gcc-symlinks \
    gdb \
    gettext \
    git \
    glibc \
    gnu-config \
    gtk+3 \
    imagemagick \
    intltool \
    libpthread-stubs \
    libssp \
    libstdc++ \
    libstdc++-dev \
    libtool \
    lsb \
    m4 \
    make \
    mtools \
    nasm \
    ncurses \
    nfs-utils \
    nfs-utils-client \
    nspr \
    p7zip \
    patch \
    pciutils \
    pkgconfig \
    procps \
    python \
    python-mako \
    python-numpy \
    python-pip \
    python-pyserial \
    rpm \
    rpm-build \
    rpmresolve \
    samba \
    strace \
    syslinux \
    tar \
    tzdata \
    udev \
    unzip \
    usbutils \
    util-linux \
    util-linux-getopt \
    vim \
    wget \
    xterm \
    yasm \
    zlib \
    "