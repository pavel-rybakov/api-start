@echo off

set DIR=%~dp0
set ROOT_DIR=%DIR%..\..
set LIQUIBASE=%DIR%..\liquibase\liquibase

if [%1]==[] goto :usage

set ENV=%1

echo %ENV%: Updating...
call "%LIQUIBASE%" --defaultsFile="%DIR%\%ENV%\liquibase.properties" --changeLogFile="%ROOT_DIR%\db-migrations\changelog.xml" update
goto :eof

:usage
  echo Usage: update ^<ENV^>
  goto :eof
