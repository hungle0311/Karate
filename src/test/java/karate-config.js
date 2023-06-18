function fn() {
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev';
  }
  var config = {
    env: env,
    username: 'kminchelle',
    password: '0lelplR',
    _url: 'http://localhost:8080',
  }
  if (env == 'dev') {
    // customize
    // e.g. config.foo = 'bar';
    config.username = 'admin';
    config.password = 'password123';
  } else if (env == 'e2e') {
    // customize
        config.username = 'admin';
        config.password = 'adminPassword';
  }else if (env == 'staging') {
       // customize
           config.username = 'staging';
           config.password = 'stagingPassword';
     }else if (env == 'preprod') {
          // customize
              config.username = 'preprod';
              config.password = 'preprodPassword';
        }else if (env == 'prod') {
             // customize
                 config.username = 'prod';
                 config.password = 'prodPassword';
           }

  config.baseUrl = 'https://jsonplaceholder.typicode.com';
  config.createUserUrl = config.baseUrl + '/' + 'users';
  config.getUserUrl = config.baseUrl + '/' + 'users';
  return config;
}