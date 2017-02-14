Vagrant.configure("2") do |config|
  config.vm.define "dockerboot" do |dockerboot|
    dockerboot.vm.box = "ubuntu/trusty64"
    dockerboot.vm.network "private_network", ip:"192.168.0.249"
    dockerboot.vm.hostname = "dockerboot"
  end  
end
