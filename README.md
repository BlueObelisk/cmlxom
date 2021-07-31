# CMLXOM
[![Build Status](https://github.com/BlueObelisk/cmlxom/actions/workflows/maven.yml/badge.svg)](https://github.com/BlueObelisk/cmlxom/actions/workflows/maven.yml)

A Java library for processing CML,
implementing the XML object model (XOM) for the Chemical Markup Language (CML).

---
**Note:**  
As of 2020-01-01 the the official home for CMLXOM is:
<https://github.com/BlueObelisk/cmlxom>.
CMLXOM's old home at: <https://bitbucket.org/wwmm/cmlxom> is subject to be
removed once Bitbucket removes all Mercurial repositories mid-2020.
---


## Releases

Instructions to increase the version:

```shell
mvn versions:set -DnewVersion=1.4-SNAPSHOT
```

Deploy to Sonatype with the following commands, for snapshots and releases respectively:

```sh1ll
mvn clean deploy
mvn clean deploy -P release
```

