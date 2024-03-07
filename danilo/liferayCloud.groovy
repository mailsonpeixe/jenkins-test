organizationFolder('LiferayCloud') {
    displayName('Liferay Cloud')
    organizations {
        github {
            credentialsId('github')
            repoOwner('LiferayCloud')
            traits {
                sourceRegexFilter {
                    regex('(admin-client|admin-server|api|cli|console|development|hosting|infrastructure-janitor|infrastructure-terraform|lcp-functional-tests|liferay-console|mongodb-sanitizer|nodegit|pmo|service-backup|service-database|service-elasticsearch|service-jenkins|service-liferay-dxp|service-nginx|service-provisioning|service-util|vpn-ipsec|vpn-openvpn|workloads-controller)')
                }
                gitHubBranchDiscovery {
                    strategyId(1)
                }
                gitHubPullRequestDiscovery {
                    strategyId(2)
                }
                gitHubTagDiscovery()
                cleanBeforeCheckoutTrait {
                    extension {
                        deleteUntrackedNestedRepositories(false)
                    }
                }
                authorInChangelogTrait()
            }
            projectFactories {
                workflowMultiBranchProjectFactory {
                    scriptPath('Jenkinsfile')
                }
            }
            buildStrategies {
                buildChangeRequests {
                    ignoreTargetOnlyChanges(false)
                    ignoreUntrustedChanges(false)
                }
                buildRegularBranches()
                buildTags {
                    atLeastDays('')
                    atMostDays('5')
                }
            }
            // comment the trigger code below to avoid starting all jobs on local machines
            triggers {
                periodicFolderTrigger {
                    interval('1m')
                }
            }
            orphanedItemStrategy {
                discardOldItems {
                    daysToKeep(-1)
                    numToKeep(-1)
                }
            }
            properties {
                organizationChildOrphanedItemsProperty {
                    strategy {
                        inherit()
                    }
                }
                noTriggerOrganizationFolderProperty {
                    branches('([mM]aster)|([pP]roduction)|([dD]evelop)|(.*[rR]c.*)|([0-9].*)|([pP]R-.*)|(LCP-.*)|(LCD-.*)|(LCH-.*)')
                }
            }
        }
    }
}