import jenkins.model.Jenkins

def jenkins = Jenkins.getInstance()
def jobname = "test_job"

def project = new FreeStyleProject(jenkins,jobname)

project.setDescription("first job through groovy")

//add parameters to the job
//single parameter
def parameterdefinition =  new StringParameterDefinition("id","xxxx","emp id")

def parameters = new ParametersDefinitionProperty.add(parameterdefinition)

project.addProperty(parameters)
project.save()
jenkins.reload()