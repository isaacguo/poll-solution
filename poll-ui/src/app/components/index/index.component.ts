import {AfterViewInit, Component, Inject, OnInit} from '@angular/core';
import {QuestionService} from "../../services/question.service";
import {Question} from "../../dto/question.model";
import {DOCUMENT} from '@angular/common';


@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  questions: Question[] = [];
  answers: number[] = [];
  url: string;
  showQRCode: boolean = false;

  constructor(private questionService: QuestionService, @Inject(DOCUMENT) private document: Document) {
    this.url = this.document.location.href;
    console.log(this.url);
  }

  ngOnInit() {
    this.questionService.getQuestions().subscribe(r => {
      this.questions = r;
    });
  }

  onItemClick(qIndex, aIndex) {
    console.log(qIndex);
    console.log(aIndex);
    this.answers[qIndex] = aIndex;
  }

  isHighlighted(qIndex: number, aIndex: number): boolean {

    if (this.answers.length < qIndex) return false;

    if (this.answers[qIndex] != null && this.answers[qIndex] === aIndex) return true;
    else return false;


  }


  onShowQRButonClicked() {
    this.showQRCode=!this.showQRCode;
  }
}
