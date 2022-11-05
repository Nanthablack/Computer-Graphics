#version 330

in vec4 vCol;
in vec2 TexCoord;
in vec3 FragPos;
in vec3 Normal;
out vec4 colour;

uniform vec3 lightColour;
uniform vec3 lightPos;

uniform vec3 viewPos;

uniform sampler2D texture2D;

vec3 ambientLight()
{
    float ambientStrenght = 0.2f;
    vec3 ambient = lightColour * ambientStrenght;
    return ambient;
}

vec3 diffuseLight()
{
    float diffuseStrenght = 0.8f;

    vec3 lightDir = normalize(lightPos-FragPos);
    vec3 norm = normalize(Normal);

    float diff = max(dot(norm,lightDir),0.0f);
    vec3 diffuse = lightColour * diff * diffuseStrenght;

    return diffuse;
}

vec3 specularLight()
{
    float specularStrenght = 0.8f;
    float shininess = 32.0f;
    vec3 lightDir = normalize(lightPos-FragPos);
    vec3 norm = normalize(Normal);
    vec3 reflectDir = reflect(-lightDir,norm);
    vec3 viewDir = normalize(viewPos-FragPos);
    float spec = pow(max(dot(viewDir,reflectDir),0.0f),shininess);
    vec3 specular = lightColour * spec * specularStrenght;

    return specular;
}

void main()
{
    
    colour = texture(texture2D, TexCoord) * vec4(ambientLight()+diffuseLight()+specularLight(),1.0f);
}