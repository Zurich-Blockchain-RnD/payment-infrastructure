import { Component, OnInit, ViewChild, ElementRef, Renderer2 } from '@angular/core';
import { Router } from '@angular/router';
import jsQR from 'jsqr';
import ethereumRegex from 'ethereum-regex';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.scss']
})
export class PayComponent implements OnInit {
  @ViewChild('trigger') public trigger: ElementRef;
  public scandone = false;
  public address;
  private videoStream;
  private responsiveWidth: number;
  constructor(
    private renderer: Renderer2,
    private router: Router
    ) { }

  ngOnInit() {


  }
  public startScan() {
    this.scandone = false;
    const video = document.createElement('video');
    const canvasElement: any = document.getElementById('canvas');
    const canvas = canvasElement.getContext('2d');
    const loadingMessage = document.getElementById('loadingMessage');
    const outputContainer = document.getElementById('output');
    const outputMessage = document.getElementById('outputMessage');
    const responsive: any = document.getElementsByClassName('embed-responsive-4by3')[0];
    if (!this.responsiveWidth) {
      this.responsiveWidth = responsive.offsetWidth;
    }

    function drawLine(begin, end, color) {
      canvas.beginPath();
      canvas.moveTo(begin.x, begin.y);
      canvas.lineTo(end.x, end.y);
      canvas.lineWidth = 4;
      canvas.strokeStyle = color;
      canvas.stroke();
    }
    const finishStream = (stream) => {
      stream.getTracks().forEach(track => track.stop());
    };
    const tick = () => {
      loadingMessage.innerText = '⌛ Loading video...';
      if (video.readyState === video.HAVE_ENOUGH_DATA) {
        loadingMessage.hidden = true;
        canvasElement.hidden = false;
        outputContainer.hidden = false;

        canvasElement.height = this.responsiveWidth;
        canvasElement.width = this.responsiveWidth;
        canvas.drawImage(video, 0, 0, canvasElement.width, canvasElement.height);
        const imageData = canvas.getImageData(0, 0, canvasElement.width, canvasElement.height);
        const code = jsQR(imageData.data, imageData.width, imageData.height);
        if (code) {

          drawLine(code.location.topLeftCorner, code.location.topRightCorner, '#FF3B58');
          drawLine(code.location.topRightCorner, code.location.bottomRightCorner, '#FF3B58');
          drawLine(code.location.bottomRightCorner, code.location.bottomLeftCorner, '#FF3B58');
          drawLine(code.location.bottomLeftCorner, code.location.topLeftCorner, '#FF3B58');
          outputMessage.hidden = true;
          const clean = code.data.match(ethereumRegex());
          this.address = clean[0];
          cancelAnimationFrame(requestAnimationFrame(tick));
          finishStream(this.videoStream);
          this.scandone = true;
        } else {
          outputMessage.hidden = false;
        }
      }
      requestAnimationFrame(tick);
    };

    navigator.mediaDevices.getUserMedia({ video: { facingMode: 'environment' } }).then((stream) => {
      video.srcObject = stream;
      video.setAttribute('playsinline', <any>true); // required to tell iOS safari we don't want fullscreen
      video.play();
      requestAnimationFrame(tick);
      this.videoStream = stream;
    }).catch((rejected) => {
      console.log(rejected);
    });
  }
  public pay() {
    this.renderer.addClass(this.trigger.nativeElement, 'drawn');
    setTimeout(() => {
      this.router.navigateByUrl('/home');
    }, 2000);
  }

}
