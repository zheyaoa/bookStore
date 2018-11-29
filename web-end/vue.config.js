let path = require('path');
function reslove(dir){
    return path.join(__dirname,dir);
}
module.exports = {
    configureWebpack:{
        resolve:{
            alias:{
                'style':'@/assets/style',
                'server':'@/pages/server',
                'admin':'@/pages/admin'
            }
        }
    }
}