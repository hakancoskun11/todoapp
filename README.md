# Todo Uygulaması

Bu proje, Spring Boot ve JWT token tabanlı Spring Security kullanılarak geliştirilmiş basit bir Todo uygulamasını içerir.

## Uygulamayı Yerelde Çalıştırma ve Test Etme

1. Proje dosyalarınızı yerel bilgisayarınıza klonlayın:

    ```bash
    git clone https://github.com/hakancoskun11/todoapp.git
    cd todoapp
    ```

2. Maven bağımlılık yöneticinizle test paketini çalıştırarak uygulamanızın doğru çalıştığından emin olun:

    ```bash
    ./mvnw test


## Uygulamayı Docker ile Çalıştırma

1. Docker'ı kullanarak uygulamanızı çalıştırmak için aşağıdaki adımları takip edin:

    ```bash
    # Docker imajını oluşturun
    docker build -t todoapplicationdemo .

    # Docker konteynerını çalıştırın
    docker run -p 8080:8080 todoapplicationdemo
    ```

2. Uygulama şimdi http://localhost:8080 adresinde çalışıyor olmalıdır.

Not: Docker'ın yüklü ve çalışır durumda olduğundan emin olun. Ayrıca, uygulamanın bağlı olduğu veritabanı veya diğer dış bağımlılıkların da uygun şekilde yapılandırıldığından emin olun.

Not2: Uygulamanın Docker Hub Linki :
[Docker Hub](https://hub.docker.com/repository/docker/hakancoskun11/todoapp/general)
