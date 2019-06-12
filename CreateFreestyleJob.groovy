import jenkins.model.Jenkins

def jenkins = Jenkins.getInstance()
def jobname = "test_job"

def project = new FreeStyleProject(jenkins,jobname)

project.setDescription("first job through groovy")

project.save()
jenkins.reload()