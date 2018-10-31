package me.xiba.demo.module_c.entity;

/**
 * @Author:liukun
 * @Date: 2018-10-30 16:27
 * @Description:
 */
public class ModuleCDaggerEntity {

    private String name;

    public ModuleCDaggerEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
