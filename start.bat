@echo off
chcp 65001 >nul
title 个人主页服务

set "JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-21.0.11.10-hotspot"
set "MAVEN_HOME=%USERPROFILE%\apache-maven-3.9.6"
set "PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%"

cd /d "%~dp0"

echo ========================================
echo   正在启动个人主页服务...
echo ========================================
echo.
echo [1/2] 启动 Spring Boot 后端...
start "SpringBoot" /MIN mvn spring-boot:run

echo [2/2] 等待服务就绪...
:wait
ping -n 3 127.0.0.1 >nul
curl -s -o NUL http://localhost:8080/ 2>nul
if errorlevel 1 goto wait

echo [3/3] 启动公网隧道 (固定域名, 自动重连)...
echo.
echo ========================================
echo   公网地址: https://swq2628.serveousercontent.com
echo   隧道断开后会自动重连, 请勿关闭此窗口!
echo ========================================
echo.

:tunnel_loop
echo [%date% %time%] 正在连接隧道...
ssh -o StrictHostKeyChecking=no -o ServerAliveInterval=60 -o ServerAliveCountMax=3 -o ExitOnForwardFailure=yes -i "%USERPROFILE%\.ssh\id_rsa" -R swq2628:80:localhost:8080 serveo.net 2>&1
echo [%date% %time%] 隧道已断开, 5秒后自动重连...
timeout /t 5 /nobreak >nul
goto tunnel_loop
