function fn(){
var env = karate.env; // get java system property 'karate.env'   karate.log('karate.env system property was:', env);
if (!env) {
env = 'dev'; // a custom 'intelligent' default
 }
var baseURl = karate.properties['baseURl'];
 karate.log('baseURl:', baseURl);
if (!baseURl) {
baseURl = 'https://gorest.co.in';
}
config = {
baseURl: baseURl,
mainURl: '/public/v2/users',
fileBaseUrl: 'http://developer.shopclues.com',
fileEndUrl: '/api/v1/upload',
authToken: '7232803c821bc49a0bd5c56d7df39c5289168e323fb17c5b6b1597d8941e33ef'
};
return config;
}