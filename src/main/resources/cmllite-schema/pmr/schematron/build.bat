@REM
@REM    Copyright 2011 Peter Murray-Rust et. al.
@REM
@REM    Licensed under the Apache License, Version 2.0 (the "License");
@REM    you may not use this file except in compliance with the License.
@REM    You may obtain a copy of the License at
@REM
@REM        http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM    Unless required by applicable law or agreed to in writing, software
@REM    distributed under the License is distributed on an "AS IS" BASIS,
@REM    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM    See the License for the specific language governing permissions and
@REM    limitations under the License.
@REM

@echo off

echo cleaning 
del .\xsl\cml-lite.xsl

echo building xsl/cml-lite.xsl
java -jar y:/saxon/saxon9.jar -o:./xsl/cml-lite.xsl -s:cml-lite.sch -xsl:./xsl/iso_svrl.xsl

echo generating documentation
java -jar y:/saxon/saxon9.jar -o:./doc/index.html -s:cml-lite.sch -xsl:./xsl/extract-doc.xsl