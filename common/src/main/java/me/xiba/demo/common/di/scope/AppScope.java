package me.xiba.demo.common.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author:liukun
 * @Date: 2018-10-30 21:12
 * @Description:
 */
@Scope
@Retention(RUNTIME)
public @interface AppScope {
}