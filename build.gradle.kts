// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id(Plugins.application).version(Plugins.applicationVersion).apply(false)
    id(Plugins.library).version(Plugins.applicationVersion).apply(false)
    id(Plugins.jetbrains).version(Plugins.jetbrainsVersion).apply(false)

}