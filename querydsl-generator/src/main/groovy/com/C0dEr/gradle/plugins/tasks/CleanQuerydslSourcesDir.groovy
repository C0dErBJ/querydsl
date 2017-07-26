package com.C0dEr.gradle.plugins.tasks

import com.C0dEr.gradle.plugins.QuerydslPlugin
import org.gradle.api.DefaultTask
import org.gradle.api.logging.Logger
import org.gradle.api.logging.Logging
import org.gradle.api.tasks.TaskAction

/**
 * This task is responsible for purging the 'querydsl' sources dir.
 *
 * @author holgerstolzenberg
 * @since 1.0.0
 */
class CleanQuerydslSourcesDir extends DefaultTask {

    private static final Logger LOG = Logging.getLogger(CleanQuerydslSourcesDir.class)

    static final String DESCRIPTION = "Cleans the Querydsl sources dir."

    CleanQuerydslSourcesDir() {
        this.group = QuerydslPlugin.TASK_GROUP
        this.description = DESCRIPTION
    }

    @SuppressWarnings("GroovyUnusedDeclaration")
    @TaskAction
    cleanSourceFolders() {
        LOG.info("Clean Querydsl source dir")
        def dir = project.file(project.querydsl.querydslSourcesDir)
        if (dir.exists()) {
            dir.deleteDir()
        }
    }
}
