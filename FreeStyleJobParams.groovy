import jenkins.model.Jenkins

def jenkins = Jenkins.getInstance()
def jobname = "test_job"

def project = new FreeStyleProject(jenkins,jobname)

project.setDescription("first job through groovy")

//add parameters to the job
//single parameter
def parameterdefinition =  new ArrayList<ParameterDefinition>()
def pnames = ["id","name"]
def values = ["xxx", "Arrthy"]
def desc = ["emp id","emp name"]

for (i in 0..1){
    parameterdefinition.add(new StringParameterDefinition(pnames[i],values[i],desc[i]))

}

/*parameterdefinition.add(new StringParameterDefinition("id","xxx","emp id"))
parameterdefinition.add(new StringParameterDefinition("name","Arrthy","emp name"))*/

parameterdefinition.add(new BooleanParameterDefinition("choose",true,"true/false"))



def parameters = new ParametersDefinitionProperty(parameterdefinition)

project.addProperty(parameters)
project.save()
jenkins.reload()